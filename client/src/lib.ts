export function disableBackButtonFunction() {
  window.addEventListener('popstate', function (event) {
    history.pushState(null, document.title, location.href);
  })
}