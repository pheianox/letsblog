export interface IPost {
  id: string;
  title: string;
  content: string;
  date: number
  author: string
}

export enum SortBy {
  Relevance,
  Popularity,
}
