// src/web.ts
import { WebPlugin } from '@capacitor/core';
export class NavigationBarIconsColorWeb extends WebPlugin {
    async setColor(options) {
        console.log('Imposta il colore della navigation bar su web', options.color);
    }
}
//# sourceMappingURL=web.js.map