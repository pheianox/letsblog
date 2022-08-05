function subscribe(eventName: number, listener: any) {
  document.addEventListener(eventName + "", listener);
}

function unsubscribe(eventName: number, listener: any) {
  document.removeEventListener(eventName + "", listener);
}

function publish(eventName: number, data: any) {
  const event = new CustomEvent(eventName + "", { detail: data });
  document.dispatchEvent(event);
}

export enum Events {
  Update,
}

export { publish, subscribe, unsubscribe };
