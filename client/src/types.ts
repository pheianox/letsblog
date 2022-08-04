export interface IPost {
  id: string;
  title: string;
  content: string;
}

export enum SortBy {
  Relevance,
  Popularity,
}
