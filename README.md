# Capacitor Navigation Bar Icons Color

![Capacitor](https://img.shields.io/badge/Capacitor-7.0.0-blue)
![Platform](https://img.shields.io/badge/Platform-Android-green)
![License](https://img.shields.io/badge/License-MIT-yellow)

Plugin Capacitor che permette di controllare il colore delle icone nella barra di navigazione Android.

## 📱 Compatibilità

- Android 8.0 (API 26) e versioni successive
- Capacitor 7.x

## 📦 Installazione

```bash
npm install github:emanueletoffolon/capacitor-navigation-bar-icons-color
npx cap sync
```
## 🚀 Utilizzo

```typescript   
import {NavigationBarIconsColor} from "@emanueletoffolon/capacitor-navigation-bar-icons-color/dist/esm";

// Imposta icone chiare (per sfondi scuri)
await NavigationBarIconsColor.setColor({ color: 'dark' });

// Imposta icone scure (per sfondi chiari)
await NavigationBarIconsColor.setColor({ color: 'light' });

```
