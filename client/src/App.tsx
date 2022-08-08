import "./App.css";
import Footer from "./components/Footer";
import PostList from "./components/PostList";
import Navbar from "./components/Navbar";
import NewPostModal from "./components/NewPostModal";
import { useEffect } from "react";
import ViewPostModal from "./components/ViewPostModal";

function App() {
  useEffect(() => {
    window.location.hash = "#";
  }, []);

  return (
    <>
      {/* Modals */}
      <NewPostModal />
      <ViewPostModal />
      {/* Other */}
      <div className="flex flex-col space-between">
        <Navbar />
        <PostList />
        <Footer />
      </div>
    </>
  );
}

export default App;
