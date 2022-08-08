import { useState } from "react";
import axios from "../axios";
import { Events, publish } from "../events";

const MAX_TITLE_LENGTH = 40;
const MAX_NAME_LENGTH = 20;

export default function NewPostModal() {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [author, setAuthor] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [isAnonoumous, setIsAnonoumus] = useState(true);

  function isTitleOk() {
    return title.length <= MAX_TITLE_LENGTH;
  }

  function isContentOk() {
    return content.length > 0;
  }

  function isAuthorOk() {
    return author.length > 0;
  }

  return (
    <div className="modal" id="newpost" onClick={() => window.location.hash = '#'}>
      <div className="modal-box text-left overflow-hidden" onClick={e => e.stopPropagation()}>
        <div className="prose">
          <h3>New Post</h3>
          <div className="form-control w-full">
            <div className="">
              <label className="label">
                <span className="label-text">Title*</span>
                <span className="label-text-alt">
                  {title.length} / {MAX_TITLE_LENGTH}
                </span>
              </label>
              <input
                type="text"
                placeholder="Type here"
                className="input input-bordered w-full"
                onChange={(v) => {
                  setTitle(v.target.value);
                }}
                maxLength={MAX_TITLE_LENGTH}
                required
                value={title}
              />
            </div>
            <div>
              <label className="label">
                <span className="label-text">Content*</span>
              </label>
              <textarea
                className="textarea textarea-bordered w-full h-40"
                style={{ resize: "none" }}
                placeholder="Type here"
                required
                onChange={(v) => {
                  setContent(v.target.value);
                }}
                value={content}
              ></textarea>
            </div>
          </div>
          <div className="flex items-start place-content-between">
            <label className="label cursor-pointer">
              <input
                type="checkbox"
                className="checkbox checkbox-secondary"
                checked={isAnonoumous}
                onChange={(v) => setIsAnonoumus(!isAnonoumous)}
              />
              <span
                className="label-text ml-4"
                onChange={(v) => setIsAnonoumus(!isAnonoumous)}
              >
                Anonymous
              </span>
            </label>
            {!isAnonoumous && (
              <div className="form-control max-w-xs">
                <label className="label">
                  <span className="label-text">What's your name?*</span>
                  <span className="label-text-alt">
                    {author.length} / {MAX_NAME_LENGTH}
                  </span>
                </label>
                <input
                  type="text"
                  placeholder="Type here"
                  className="input input-bordered w-full max-w-xs"
                  onChange={(v) => {
                    setAuthor(v.target.value);
                  }}
                  maxLength={MAX_NAME_LENGTH}
                  value={author}
                  required
                />
              </div>
            )}
          </div>
        </div>
        <div className="modal-action">
          <button
            type="submit"
            className={`btn ${isLoading ? "loading" : ""}`}
            disabled={
              !(
                isTitleOk() &&
                isContentOk() &&
                (isAnonoumous ? true : isAuthorOk())
              )
            }
            onClick={() => {
              setIsLoading(true);
              axios
                .post("/posts", { title, content, author: isAnonoumous ? undefined : author })
                .then((res) => {
                  console.log(res.data);
                  window.location.hash = "#";
                  publish(Events.Update, null);
                  setTitle("")
                  setContent("")
                  setAuthor("")
                })
                .catch(console.error)
                .finally(() => {
                  setIsLoading(false);
                });
            }}
          >
            Publish
          </button>
        </div>
      </div>
    </div>
  );
}
