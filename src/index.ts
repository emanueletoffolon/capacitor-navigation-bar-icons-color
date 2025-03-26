import { registerPlugin } from '@capacitor/core';

export interface NavigationBarIconsColorPlugin {
    setColor(options: { color: string }): Promise<void>;
}

const NavigationBarIconsColor = registerPlugin<NavigationBarIconsColorPlugin>('NavigationBarIconsColor', {
    web: () => import('./web').then(m => new m.NavigationBarIconsColorWeb()),
});

export * from './definitions';
export { NavigationBarIconsColor };