import { useEffect, useState } from "react";
import axios from "../axios";
import { IPost } from "../types";

export default function PostList() {
  const [posts, setPosts] = useState<IPost[]>([]);

  useEffect(() => {
    axios.get("/posts").then((res) => setPosts(res.data));
  }, []);

  return (
    <div className="grid ">
      {posts.length <= 0 ? (
        <progress className="progress w-56"></progress>
      ) : (
        posts.map(({ title, content, id }) => (
          <div className="card w-96 bg-base-100 shadow-xl" key={id}>
            <figure></figure>
            <div className="card-body">
              <h2 className="card-title">
                {title}
                <div className="badge badge-secondary">NEW</div>
              </h2>
              <p>{content.slice(0, 50)}...</p>
              <div className="card-actions justify-end">
                <div className="badge badge-outline">Fashion</div>
                <div className="badge badge-outline">Products</div>
              </div>
            </div>
          </div>
        ))
      )}
    </div>
  );
}
