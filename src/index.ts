import { registerPlugin } from '@capacitor/core';

import type { SimInformationsPlugin } from './definitions';

const SimInformations = registerPlugin<SimInformationsPlugin>(
  'SimInformations',
  {
    web: () => import('./web').then(m => new m.SimInformationsWeb()),
  },
);

export * from './definitions';
export { SimInformations };
