import { registerPlugin } from '@capacitor/core';

import type { BeatOnePlugin } from './definitions';

const BeatOne = registerPlugin<BeatOnePlugin>('BeatOne', {
  web: () => import('./web').then(m => new m.BeatOneWeb()),
});

export * from './definitions';
export { BeatOne };
