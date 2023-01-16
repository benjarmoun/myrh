import {rh} from "./rh";
import {ProfileId} from "./profile";

export interface jobOffer {
  id: number,
  title: string,
  description: string,
  profile: ProfileId,
  city: string,
  degree: string,
  salary: number,
  status: boolean,
  rh: rh,
  rhId: number,
  profileId: ProfileId,
}
