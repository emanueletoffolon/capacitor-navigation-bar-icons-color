import { registerPlugin } from '@capacitor/core';

const NavigationBarIconsColor = registerPlugin('NavigationBarIconsColor', {
    web: () => import('./web-CgldkJvZ.js').then(m => new m.NavigationBarIconsColorWeb()),
});

export { NavigationBarIconsColor };
//# sourceMappingURL=index.js.map
