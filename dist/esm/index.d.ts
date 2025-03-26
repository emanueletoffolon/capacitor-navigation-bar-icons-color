export interface NavigationBarIconsColorPlugin {
    setColor(options: {
        color: string;
    }): Promise<void>;
}
declare const NavigationBarIconsColor: NavigationBarIconsColorPlugin;
export * from './definitions';
export { NavigationBarIconsColor };
