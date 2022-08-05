import { useEffect, useState } from "react";
import axios from "../axios";
import { Events, subscribe, unsubscribe } from "../events";
import { IPost } from "../types";
import ViewsIcon from "./ViewsIcon";

export default function PostList() {
  const [posts, setPosts] = useState<IPost[]>([]);

  function update() {
    axios.get("/posts").then((res) => setPosts(res.data));
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
          ? "Loading... (this might take some time)"
          : posts.map(({ title, content, id }) => (
              <div
                className="card card-compact w-96 bg-base-100 shadow-xl"
                key={id}
              >
                <div className="prose card-body">
                  <h2 className="card-title">{title}</h2>
                  <p className="text-left">{content.slice(0, 30)}...</p>
                  <div className="card-actions justify-between items-center">
                    <div>
                      <div className="flex gap-2 items-center justify-center">
                        <ViewsIcon /> 15
                      </div>
                    </div>
                    <button className="btn btn-md btn-primary">Read</button>
                  </div>
                </div>
              </div>
            ))}
      </div>
    </div>
  );
}
