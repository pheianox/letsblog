import "./App.css";
import Footer from "./components/Footer";
import PostList from "./components/PostList";
import Navbar from "./components/Navbar";

function App() {
  return (
    <div className="flex flex-col space-between">
      <Navbar />
      <PostList />
      <Footer />
    </div>
  );
}

export default App;
