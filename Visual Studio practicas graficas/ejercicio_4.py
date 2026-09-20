import numpy as np
import matplotlib.pyplot as plt
from matplotlib import patches
import os

SAVE_PATH = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'ej4_indeterminacion.png')

fig, axes = plt.subplots(1, 3, figsize=(15, 5))
fig.suptitle('Ejercicio 4 — Tipo de indeterminacion: lim (x^2 - 1) / (x - 1) cuando x -> 1\nRespuesta: A = 0/0',
             fontsize=12, fontweight='bold', color='#1e3a5f')

# ── Panel 1: La funcion con hueco en x=1 ──
ax1 = axes[0]

x1 = np.linspace(-1, 0.97, 200)
x2 = np.linspace(1.03, 3, 200)

def f(x):
    return (x**2 - 1) / (x - 1)   # = x + 1 para x != 1

ax1.plot(x1, f(x1), color='#0ea5e9', lw=2.5, label='f(x) = (x^2-1)/(x-1)')
ax1.plot(x2, f(x2), color='#0ea5e9', lw=2.5)

# Hueco en x=1 (valor no definido)
ax1.plot(1, 2, 'o', color='#0ea5e9', markersize=12,
         markerfacecolor='white', markeredgewidth=2.5, zorder=5, label='Hueco en x=1')

ax1.axvline(x=1, color='#f59e0b', linestyle='--', lw=1.5, alpha=0.7, label='x = 1')
ax1.axhline(y=2, color='#4ade80',  linestyle=':', lw=1.5, alpha=0.7, label='y = 2 (limite)')

# Sustitucion directa — muestra el 0/0
ax1.text(0.03, 0.96,
         "Sustitucion directa x=1:\n\n"
         "  Numerador:  1^2 - 1 = 0\n"
         "  Denominador: 1 - 1  = 0\n\n"
         "  Resultado: 0/0\n"
         "  --> INDETERMINACION",
         transform=ax1.transAxes, fontsize=9, va='top',
         bbox=dict(boxstyle='round', facecolor='#fef3c7', edgecolor='#f59e0b', alpha=0.95),
         fontfamily='monospace', color='#1e293b')

ax1.annotate('x=1 da 0/0\n(indeterminado)', xy=(1, 2), xytext=(1.8, 1.2),
             arrowprops=dict(arrowstyle='->', color='#f87171', lw=1.5),
             fontsize=8.5, color='#f87171', ha='center',
             bbox=dict(boxstyle='round', facecolor='#fee2e2', alpha=0.85))

ax1.set_title('Sustitucion directa -> 0/0\n[Indeterminacion tipo A]',
              fontsize=9, fontweight='bold', color='#1e3a5f')
ax1.set_xlabel('x'); ax1.set_ylabel('f(x)')
ax1.legend(fontsize=8, loc='lower right')
ax1.grid(True, alpha=0.3); ax1.set_facecolor('#f8fafc')
ax1.set_xlim(-1, 3); ax1.set_ylim(0, 4)

# ── Panel 2: Resolucion por factorizacion ──
ax2 = axes[1]

x_all = np.linspace(-1, 3, 400)
g = x_all + 1  # forma simplificada

ax2.plot(x_all, g, color='#a78bfa', lw=2.5, linestyle='--',
         label='g(x) = x+1 (simplificada)', alpha=0.7)
ax2.plot(x1, f(x1), color='#0ea5e9', lw=2.5, label='f(x) original')
ax2.plot(x2, f(x2), color='#0ea5e9', lw=2.5)
ax2.plot(1, 2, 'o', color='#0ea5e9', markersize=12,
         markerfacecolor='white', markeredgewidth=2.5, zorder=5)
ax2.plot(1, 2, '*', color='#f59e0b', markersize=16, zorder=6, label='Limite = 2')

ax2.axvline(x=1, color='#f59e0b', linestyle='--', lw=1.5, alpha=0.6)
ax2.axhline(y=2, color='#4ade80',  linestyle=':', lw=1.5, alpha=0.6)

# Pasos de factorizacion
ax2.text(0.03, 0.97,
         "Factorizacion:\n\n"
         "x^2 - 1 = (x+1)(x-1)\n\n"
         "  (x+1)(x-1)\n"
         "  ----------  = x+1\n"
         "    (x-1)\n\n"
         "lim (x+1) = 1+1 = 2\n"
         "x->1\n\n"
         "El limite EXISTE = 2",
         transform=ax2.transAxes, fontsize=9, va='top',
         bbox=dict(boxstyle='round', facecolor='#eff6ff', edgecolor='#0ea5e9', alpha=0.95),
         fontfamily='monospace', color='#1e293b')

ax2.set_title('Resolucion: factorizar para levantar\nla indeterminacion 0/0',
              fontsize=9, fontweight='bold', color='#1e3a5f')
ax2.set_xlabel('x'); ax2.set_ylabel('f(x)')
ax2.legend(fontsize=8, loc='lower right')
ax2.grid(True, alpha=0.3); ax2.set_facecolor('#f8fafc')
ax2.set_xlim(-1, 3); ax2.set_ylim(0, 4)

# ── Panel 3: Comparacion de los 4 tipos de indeterminacion ──
ax3 = axes[2]
ax3.axis('off')
ax3.set_facecolor('#f8fafc')
ax3.set_title('Los 4 tipos de indeterminacion del examen\n(y cuando ocurre cada uno)',
              fontsize=9, fontweight='bold', color='#1e3a5f')

# Tabla comparativa
col_labels = ['Tipo', 'Cuando ocurre', 'Ejemplo', 'Este ejercicio']
table_data = [
    ['A:  0/0',    'Num y den -> 0',     '(x^2-1)/(x-1)\ncuando x->1',  'SI  (CORRECTA)'],
    ['B: inf/inf', 'Num y den -> inf',   '(x^2+1)/(x+3)\ncuando x->inf','NO'],
    ['C: 0 * inf', 'Un factor ->0\notro ->inf', 'x * (1/x)\ncuando x->0','NO'],
    ['D: No existe','No aplica\nindeterminacion', 'f(x)=5\nconstante',   'NO'],
]

colors_tbl = [
    ['#dcfce7', '#dcfce7', '#dcfce7', '#dcfce7'],  # fila A - verde (correcta)
    ['#f8fafc', '#f8fafc', '#f8fafc', '#f8fafc'],
    ['#f8fafc', '#f8fafc', '#f8fafc', '#f8fafc'],
    ['#f8fafc', '#f8fafc', '#f8fafc', '#f8fafc'],
]

tbl = ax3.table(cellText=table_data, colLabels=col_labels,
                cellLoc='center', loc='center',
                cellColours=colors_tbl)
tbl.auto_set_font_size(False)
tbl.set_fontsize(8.5)
tbl.scale(1.3, 2.2)

# Encabezado azul
for j in range(4):
    tbl[0, j].set_facecolor('#1e3a5f')
    tbl[0, j].set_text_props(color='white', fontweight='bold')

# Fila correcta en verde fuerte
for j in range(4):
    tbl[1, j].set_facecolor('#bbf7d0')
    tbl[1, j].set_text_props(color='#166534', fontweight='bold')

ax3.text(0.5, 0.03,
         'La indeterminacion 0/0 se resuelve\nfactorizando o aplicando L\'Hopital',
         transform=ax3.transAxes, fontsize=8.5, ha='center',
         bbox=dict(boxstyle='round', facecolor='#fef3c7', edgecolor='#f59e0b', alpha=0.9))

plt.tight_layout()
plt.savefig(SAVE_PATH, dpi=150, bbox_inches='tight', facecolor='white')
print(f"Guardado en: {SAVE_PATH}")
plt.show()