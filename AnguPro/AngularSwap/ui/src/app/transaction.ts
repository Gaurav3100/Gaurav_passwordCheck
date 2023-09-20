import { Cycle } from "./cycle";

export interface transaction {
    id: number;
    username: string;
    items: Cycle[];
    totalPrice: number;
    purchasedTime: Date;
  }