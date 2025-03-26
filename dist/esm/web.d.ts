import { WebPlugin } from '@capacitor/core';
import { NavigationBarIconsColorPlugin } from './definitions';
export declare class NavigationBarIconsColorWeb extends WebPlugin implements NavigationBarIconsColorPlugin {
    setColor(options: {
        color: string;
    }): Promise<void>;
}
