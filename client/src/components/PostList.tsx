import { useEffect, useState } from "react";
import axios from "../axios";
import { IPost } from "../types";
import PostListItem from "./PostListItem";

export default function PostList() {
  const [posts, setPosts] = useState<IPost[]>([]);

  useEffect(() => {
    axios.get("/posts").then((res) => setPosts(res.data));
  }, []);

  return (
    <div className="list">
      {posts.map((post) => (
        <PostListItem {...post} />
      ))}
    </div>
  );
}
