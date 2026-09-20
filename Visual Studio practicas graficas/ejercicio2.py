import numpy as np
import matplotlib.pyplot as plt
import os
import tempfile

fig, axes = plt.subplots(1, 3, figsize=(15, 5))
fig.suptitle('Ejercicio 2 — Limite: lim (x^2 - 4) / (x - 2) cuando x -> 2\nRespuesta: B = 4',
             fontsize=12, fontweight='bold', color='#1e3a5f')

# ── Panel 1: La funcion original con hueco en x=2 ──
ax1 = axes[0]

x1 = np.linspace(-1, 1.97, 200)
x2 = np.linspace(2.03, 5, 200)

def f(x):
    return (x**2 - 4) / (x - 2)  # = x + 2 para x != 2

ax1.plot(x1, f(x1), color='#0ea5e9', lw=2.5, label='f(x) = (x²-4)/(x-2)')
ax1.plot(x2, f(x2), color='#0ea5e9', lw=2.5)

# Hueco en x=2 (discontinuidad removible)
ax1.plot(2, 4, 'o', color='#0ea5e9', markersize=11,
         markerfacecolor='white', markeredgewidth=2.5, zorder=5, label='Hueco en x=2 (no definida)')

# Lineas de referencia
ax1.axvline(x=2, color='#f59e0b', linestyle='--', lw=1.5, alpha=0.7, label='x = 2')
ax1.axhline(y=4, color='#4ade80', linestyle=':', lw=1.5, alpha=0.7, label='y = 4 (limite)')

ax1.plot(2, 4, 'o', color='#4ade80', markersize=6, zorder=4)

ax1.set_title('Funcion original\nHueco en x=2 (indeterminacion 0/0)', fontsize=9, fontweight='bold', color='#1e3a5f')
ax1.set_xlabel('x'); ax1.set_ylabel('f(x)')
ax1.legend(fontsize=8)
ax1.grid(True, alpha=0.3)
ax1.set_facecolor('#f8fafc')
ax1.set_xlim(-1, 5)
ax1.set_ylim(0, 7)

# Anotacion del hueco
ax1.annotate('Indefinida en x=2\n(0/0 → hueco)', xy=(2, 4), xytext=(3.2, 2.5),
             arrowprops=dict(arrowstyle='->', color='#f87171', lw=1.5),
             fontsize=8.5, color='#f87171', ha='center',
             bbox=dict(boxstyle='round', facecolor='#fee2e2', alpha=0.8))

# ── Panel 2: Factorizacion paso a paso ──
ax2 = axes[1]

# Funcion simplificada g(x) = x + 2
x_all = np.linspace(-1, 5, 300)
g = x_all + 2  # funcion simplificada

ax2.plot(x_all, g, color='#a78bfa', lw=2.5, linestyle='--', label='g(x) = x + 2 (simplificada)', alpha=0.7)
ax2.plot(x1, f(x1), color='#0ea5e9', lw=2.5, label='f(x) original')
ax2.plot(x2, f(x2), color='#0ea5e9', lw=2.5)
ax2.plot(2, 4, 'o', color='#0ea5e9', markersize=11,
         markerfacecolor='white', markeredgewidth=2.5, zorder=5)
ax2.plot(2, 4, '*', color='#f59e0b', markersize=15, zorder=6, label='Limite = 4')

ax2.axvline(x=2, color='#f59e0b', linestyle='--', lw=1.5, alpha=0.7)
ax2.axhline(y=4, color='#4ade80', linestyle=':', lw=1.5, alpha=0.7)

# Texto con la factorizacion
pasos = (
    "Factorizacion:\n"
    "x² - 4 = (x+2)(x-2)\n\n"
    "  (x+2)(x-2)\n"
    "  ————————————  = x+2\n"
    "     (x-2)\n\n"
    "lim (x+2) = 2+2 = 4\nx→2"
)
ax2.text(0.03, 0.97, pasos, transform=ax2.transAxes,
         fontsize=9, va='top', ha='left', color='#1e293b',
         bbox=dict(boxstyle='round', facecolor='#eff6ff', edgecolor='#0ea5e9', alpha=0.95),
         fontfamily='monospace')

ax2.set_title('Simplificacion por factorizacion\n(x+2)(x-2)/(x-2) = x+2', fontsize=9, fontweight='bold', color='#1e3a5f')
ax2.set_xlabel('x'); ax2.set_ylabel('f(x)')
ax2.legend(fontsize=8, loc='lower right')
ax2.grid(True, alpha=0.3)
ax2.set_facecolor('#f8fafc')
ax2.set_xlim(-1, 5)
ax2.set_ylim(0, 7)

# ── Panel 3: Tabla de aproximacion numerica ──
ax3 = axes[2]
ax3.set_facecolor('#f8fafc')
ax3.axis('off')

ax3.set_title('Aproximacion numerica a x = 2\n(valores de f(x) cada vez mas cerca)', fontsize=9, fontweight='bold', color='#1e3a5f')

# Valores que se aproximan a 2
x_izq = [1.0, 1.5, 1.9, 1.99, 1.999, 2.0,  2.001, 2.01, 2.1, 2.5, 3.0]
labels = ['1.0','1.5','1.9','1.99','1.999','→2←','2.001','2.01','2.1','2.5','3.0']
fx_vals = [f(xi) if abs(xi - 2) > 0.0001 else float('nan') for xi in x_izq]
fx_labels = [f'{v:.4f}' if not np.isnan(v) else 'UNDEF' for v in fx_vals]

col_labels = ['x', 'f(x) = (x²-4)/(x-2)']
table_data = list(zip(labels, fx_labels))

colors_row = []
for xi in x_izq:
    if abs(xi - 2) < 0.0001:
        colors_row.append(['#fef3c7', '#fef3c7'])
    elif xi < 2:
        colors_row.append(['#ede9fe', '#ede9fe'])
    else:
        colors_row.append(['#fce7f3', '#fce7f3'])

tbl = ax3.table(cellText=table_data, colLabels=col_labels,
                cellLoc='center', loc='center',
                cellColours=colors_row)
tbl.auto_set_font_size(False)
tbl.set_fontsize(9.5)
tbl.scale(1.4, 1.55)

# Encabezados
for j in range(2):
    tbl[0, j].set_facecolor('#1e3a5f')
    tbl[0, j].set_text_props(color='white', fontweight='bold')

# Fila del punto no definido
tbl[6, 0].set_facecolor('#fef9c3')
tbl[6, 1].set_facecolor('#fee2e2')
tbl[6, 1].set_text_props(color='#dc2626', fontweight='bold')

# Leyenda colores
ax3.text(0.5, 0.02,
         'Morado: x se acerca desde izq   Rosa: desde der\nAmbos lados convergen a 4',
         transform=ax3.transAxes, fontsize=8, ha='center',
         bbox=dict(boxstyle='round', facecolor='#f0fdf4', edgecolor='#4ade80', alpha=0.9))

plt.tight_layout()
out_path = os.path.join(tempfile.gettempdir(), 'ej2.png')
plt.savefig(out_path, dpi=150, bbox_inches='tight', facecolor='white')
print('Saved plot to:', out_path)