import { useEffect, useState } from "react";
import axios from "../axios";
import { IPost } from "../types";
import ViewsIcon from "./ViewsIcon";

export default function PostList() {
  const [posts, setPosts] = useState<IPost[]>([]);

  useEffect(() => {
    axios.get("/posts").then((res) => setPosts(res.data));
  }, []);

  return (
    <div className="mt-2 flex min-h-[6rem] min-w-[18rem]  flex-wrap items-center justify-center gap-2   p-2">
      {posts.length <= 0
        ? "Loading..."
        : posts.map(({ title, content, id }) => (
            <div className="card w-96 bg-base-100 shadow-xl">
              <div className="card-body">
                <h2 className="card-title">Card title!</h2>
                <p className="text-left">{content.slice(0, 30)}...</p>
                <div className="card-actions justify-between items-center mt-4">
                  <div>
                    <div className="flex gap-2 items-center justify-center">
                      <ViewsIcon /> 15
                    </div>
                  </div>

                  <button className="btn btn-primary">Read</button>
                </div>
              </div>
            </div>
          ))}
    </div>
  );
}
