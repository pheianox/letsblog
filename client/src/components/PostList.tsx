import { useEffect, useState } from "react";
import axios from "../axios";
import { Events, publish, subscribe, unsubscribe } from "../events";
import { IPost } from "../types";

export default function PostList() {
  const [posts, setPosts] = useState<IPost[]>([]);
  const [isLoading, setIsLoading] = useState(false)

  function update() {
    setIsLoading(true)
    axios
      .get("/posts")
      .then((res) => setPosts(res.data))
      .finally(() => setIsLoading(false));
  }

  useEffect(() => {
    update();
    subscribe(Events.Update, update);
    return () => {
      unsubscribe(Events.Update, update);
    };
  }, []);

  return (
    <div className="mt-2 min-h-[6rem] min-w-[18rem]">
      <div className="flex">{/* <SortDropdown /> */}</div>
      <div className="flex-none"></div>
      <div className="flex flex-wrap items-center justify-center gap-2 p-2 select-none">
        {posts.length <= 0
          ? isLoading ? 'Loading...' : 'No posts yet'
          : posts.map((post, idx) => {
            const { title, content, id, author, date } = post
            return (
              <div
                className="card card-compact w-96 bg-base-100 shadow-xl"
                key={id}
              >
                <div className="prose card-body">
                  <h2 className="text-left card-title pb-3">{title}</h2>
                  <p className="text-left">{content.slice(0, 30)}...</p>
                  <div className="card-actions justify-between items-center">
                    {author ? author : '(Anonymous)'}
                    <button className="btn btn-md btn-primary" onClick={() => publish(Events.View, post)}>Read</button>
                  </div>
                </div>
              </div>
            )
          })}
      </div>
    </div>
  );
}
