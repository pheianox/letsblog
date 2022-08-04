export default function Navbar() {
  return (
    <div className="navbar bg-base-100 ">
      <div className="flex-1">
        <a className="btn btn-ghost normal-case text-xl">LetsBlog</a>
      </div>

      <div className="flex-end">
        <div className="btn btn">Create</div>
      </div>
    </div>
  );
}
