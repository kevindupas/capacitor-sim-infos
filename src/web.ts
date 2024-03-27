import { WebPlugin } from '@capacitor/core';

import type { SimInformationsPlugin } from './definitions';

export class SimInformationsWeb
  extends WebPlugin
  implements SimInformationsPlugin
{
  // Dans web.ts
  async getOperatorAndNetworkType(): Promise<{ operatorName: string; networkType: string }> {
    console.warn("SimInformations functionality not available on web.");
    return { operatorName: "Unknown", networkType: "Unknown" };
  }

}
