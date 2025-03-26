import { registerPlugin } from '@capacitor/core';
const NavigationBarIconsColor = registerPlugin('NavigationBarIconsColor', {
    web: () => import('./web').then(m => new m.NavigationBarIconsColorWeb()),
});
export * from './definitions';
export { NavigationBarIconsColor };
//# sourceMappingURL=index.js.map