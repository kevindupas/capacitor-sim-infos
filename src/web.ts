import { WebPlugin } from '@capacitor/core';

import type { SimInformationsPlugin } from './definitions';

export class SimInformationsWeb
  extends WebPlugin
  implements SimInformationsPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
