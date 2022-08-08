import moment from "moment"
import { useEffect, useState } from "react"
import { Events, subscribe } from "../events"
import { IPost } from "../types"

export default function ViewPostModal() {
  const [post, setPost] = useState<IPost>()
  
  useEffect(() => {
    subscribe(Events.View, (event: CustomEvent) => {
      setPost(event.detail)
      window.location.hash = 'post'
    })
  }, [])

  return  <div className="modal" id="post" onClick={() => window.location.hash = '#'}>
            <div className="modal-box select-none" onClick={e => e.stopPropagation()}>
              <div className="prose text-left">
                <h2>{post?.title}</h2>
                <p className="py-4">{post?.content}</p>
                <div className="flex flex-start">
                  {post?.author &&  <div className="badge badge-accent mr-1">{post.author}</div>}
                  <div className="badge badge-accent">{moment.unix(post?.date || 0).format('D MMM YYYY')}</div>
                </div>
              </div>
            </div>
          </div>
}