import { useState } from "react";
import { SortBy } from "../types";

export default function SortDropDown() {
  const [isOpened, setIsOpened] = useState(false);
  const [sortCriteria, setSortCriteria] = useState<SortBy>(SortBy.Relevance);

  return (
    <div
      className={"dropdown text-sm"}
      onMouseOver={() => setIsOpened(true)}
      onMouseOut={() => setIsOpened(false)}
    >
      <label tabIndex={0} className="btn m-1">
        Sort By
      </label>
      <ul
        tabIndex={0}
        className={
          (isOpened ? "" : "hidden") +
          " dropdown-content menu p-2 shadow bg-base-100 rounded-box w-52"
        }
        onClick={() => {
          setIsOpened((s) => !s);
        }}
      >
        <li>
          <a>Relevance</a>
        </li>
        <li>
          <a>Popularity</a>
        </li>
      </ul>
    </div>
  );
}
