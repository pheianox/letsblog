import "./App.css";
import Footer from "./components/Footer";

const BASE_URL = "https://pheianox-letsblog.herokuapp.com/api/v1";

function App() {
  return (
    <div className="navbar bg-base-100">
      <div className="flex-1">
        <a className="btn btn-ghost normal-case text-xl">LetsBlog</a>
      </div>

      <div className="flex-end">
        <div className="btn btn">Create</div>
      </div>
    </div>
  );
}

export default App;
