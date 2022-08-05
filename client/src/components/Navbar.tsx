export default function Navbar() {
  return (
    <div className="navbar bg-base-100 mb-4">
      <div className="flex-1">
        <a className="btn btn-ghost normal-case text-xl" href="/">
          LetsBlog
        </a>
      </div>

      <div className="flex-end">
        <div
          className="btn btn"
          onClick={() => (window.location.hash = "#newpost")}
        >
          Create
        </div>
      </div>
    </div>
  );
}
