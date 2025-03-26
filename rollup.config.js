import nodeResolve from '@rollup/plugin-node-resolve';
import typescript from '@rollup/plugin-typescript';

export default {
    input: 'src/index.ts',
    output: {
        dir: 'dist',
        entryFileNames: '[name].js',
        format: 'es',
        sourcemap: true
    },
    external: ['@capacitor/core'],
    plugins: [
        nodeResolve(),
        typescript({
            tsconfig: 'tsconfig.json'
        })
    ]
};