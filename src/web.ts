// src/web.ts
import { WebPlugin } from '@capacitor/core';

import { NavigationBarIconsColorPlugin } from './definitions';

export class NavigationBarIconsColorWeb extends WebPlugin implements NavigationBarIconsColorPlugin {
    async setColor(options: { color: string }): Promise<void> {
        console.log('Imposta il colore della navigation bar su web', options.color);
    }
}