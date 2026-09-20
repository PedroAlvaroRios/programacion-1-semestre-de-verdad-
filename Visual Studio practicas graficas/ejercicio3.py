import numpy as np
import matplotlib.pyplot as plt
from matplotlib import patches
import os

SAVE_PATH = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'ej3_asintota_vertical.png')

fig, axes = plt.subplots(1, 3, figsize=(15, 5))
fig.suptitle('Ejercicio 3 - Cuando el limite tiende a infinito, la grafica muestra:\nRespuesta: B = Una asintota vertical',
             fontsize=12, fontweight='bold', color='#1e3a5f')

def f(x):
    return 1 / (x - 1)

x1 = np.linspace(-3, 0.97, 300)
x2 = np.linspace(1.03, 4, 300)

ax1 = axes[0]
ax1.plot(x1, np.clip(f(x1), -8, 8), color='#0ea5e9', lw=2.5, label='f(x) = 1/(x-1)')
ax1.plot(x2, np.clip(f(x2), -8, 8), color='#0ea5e9', lw=2.5)
ax1.axvline(x=1, color='#f87171', linestyle='--', lw=2.5, label='Asintota vertical x=1', zorder=3)
ax1.annotate('', xy=(1.05, 7.5), xytext=(1.05, 4),
             arrowprops=dict(arrowstyle='->', color='#f59e0b', lw=2))
ax1.annotate('', xy=(0.95, -7.5), xytext=(0.95, -4),
             arrowprops=dict(arrowstyle='->', color='#f59e0b', lw=2))
ax1.text(1.8, 5.5, 'f(x) -> +inf\ncuando x->1+', fontsize=8.5, color='#f59e0b',
         bbox=dict(boxstyle='round', facecolor='#fef3c7', alpha=0.9))
ax1.text(-2.5, -6.5, 'f(x) -> -inf\ncuando x->1-', fontsize=8.5, color='#f59e0b',
         bbox=dict(boxstyle='round', facecolor='#fef3c7', alpha=0.9))
ax1.text(1.1, -1.5, 'x = 1\nAsintota\nvertical', fontsize=8, color='#f87171', fontweight='bold')
ax1.set_title('B: ASINTOTA VERTICAL [CORRECTA]\nlim f(x) = +/-inf cuando x -> 1',
              fontsize=9, fontweight='bold', color='#166534')
ax1.set_xlabel('x'); ax1.set_ylabel('f(x)')
ax1.legend(fontsize=8, loc='upper right'); ax1.grid(True, alpha=0.3)
ax1.set_facecolor('#f0fdf4'); ax1.set_xlim(-3, 4); ax1.set_ylim(-8, 8)
rect = patches.FancyBboxPatch((0.6, 0.03), 0.37, 0.13, transform=ax1.transAxes,
    boxstyle="round,pad=0.02", facecolor='#dcfce7', edgecolor='#4ade80')
ax1.add_patch(rect)
ax1.text(0.785, 0.095, 'CORRECTA', transform=ax1.transAxes,
         fontsize=9, color='#166534', ha='center', va='center', fontweight='bold')

ax2 = axes[1]
x_all = np.linspace(-3, 4, 400)
mask = np.abs(x_all - 1) > 0.07
y_hueco = x_all + 1
ax2.plot(x_all[mask], y_hueco[mask], color='#a78bfa', lw=2.5, label='g(x) = x+1 (hueco en x=1)')
ax2.plot(1, 2, 'o', color='#a78bfa', markersize=11,
         markerfacecolor='white', markeredgewidth=2.5, zorder=5)
ax2.plot(x1, np.clip(f(x1), -8, 8), color='#0ea5e9', lw=2, linestyle='--', alpha=0.6, label='f(x)=1/(x-1) (asintota)')
ax2.plot(x2, np.clip(f(x2), -8, 8), color='#0ea5e9', lw=2, linestyle='--', alpha=0.6)
ax2.axvline(x=1, color='#f87171', linestyle='--', lw=1.5, alpha=0.5)
ax2.annotate('Hueco circular:\nlimite FINITO\n(no va a infinito)', xy=(1, 2), xytext=(-1.5, 5),
             arrowprops=dict(arrowstyle='->', color='#a78bfa', lw=1.5),
             fontsize=8.5, color='#a78bfa', ha='center',
             bbox=dict(boxstyle='round', facecolor='#ede9fe', alpha=0.85))
ax2.annotate('Asintota vertical:\nlimite INFINITO\n(respuesta correcta)', xy=(1.15, 3), xytext=(2.5, -5),
             arrowprops=dict(arrowstyle='->', color='#0ea5e9', lw=1.5),
             fontsize=8.5, color='#0ea5e9', ha='center',
             bbox=dict(boxstyle='round', facecolor='#eff6ff', alpha=0.85))
ax2.set_title('A: Hueco circular [INCORRECTA]\nEl hueco ocurre cuando el limite es FINITO',
              fontsize=9, fontweight='bold', color='#991b1b')
ax2.set_xlabel('x'); ax2.set_ylabel('f(x)')
ax2.legend(fontsize=8, loc='upper left'); ax2.grid(True, alpha=0.3)
ax2.set_facecolor('#fff1f2'); ax2.set_xlim(-3, 4); ax2.set_ylim(-8, 8)
rect2 = patches.FancyBboxPatch((0.6, 0.03), 0.37, 0.13, transform=ax2.transAxes,
    boxstyle="round,pad=0.02", facecolor='#fee2e2', edgecolor='#f87171')
ax2.add_patch(rect2)
ax2.text(0.785, 0.095, 'INCORRECTA', transform=ax2.transAxes,
         fontsize=9, color='#991b1b', ha='center', va='center', fontweight='bold')

ax3 = axes[2]
ax3.set_facecolor('#f8fafc'); ax3.set_xlim(0,10); ax3.set_ylim(0,10); ax3.axis('off')
ax3.set_title('Resumen: tipos de representacion grafica\nsegun el comportamiento del limite',
              fontsize=9, fontweight='bold', color='#1e3a5f')

ins1 = ax3.inset_axes([0.02, 0.52, 0.45, 0.44])
xA1 = np.linspace(0.1, 0.88, 100)
xA2 = np.linspace(1.12, 2.0, 100)
ins1.plot(xA1, np.clip(1/(xA1-1), -10, 10), color='#0ea5e9', lw=2)
ins1.plot(xA2, np.clip(1/(xA2-1), -10, 10), color='#0ea5e9', lw=2)
ins1.axvline(x=1, color='#f87171', lw=2, linestyle='--')
ins1.set_ylim(-8,8); ins1.set_xlim(0,2)
ins1.set_title('B: Asintota vertical\n[CORRECTA]', fontsize=7.5, color='#166534', fontweight='bold')
ins1.set_facecolor('#f0fdf4'); ins1.grid(True, alpha=0.3)

ins2 = ax3.inset_axes([0.53, 0.52, 0.45, 0.44])
xB = np.linspace(0, 2, 300)
maskB = np.abs(xB - 1) > 0.08
ins2.plot(xB[maskB], (xB+1)[maskB], color='#a78bfa', lw=2)
ins2.plot(1, 2, 'o', color='#a78bfa', markersize=8, markerfacecolor='white', markeredgewidth=2)
ins2.set_title('A: Hueco circular\n[INCORRECTA]', fontsize=7.5, color='#991b1b', fontweight='bold')
ins2.set_facecolor('#fff1f2'); ins2.grid(True, alpha=0.3)

ins3 = ax3.inset_axes([0.02, 0.04, 0.45, 0.44])
xC = np.linspace(0, 2, 100)
ins3.plot(xC, np.ones_like(xC)*2, color='#f59e0b', lw=2)
ins3.set_title('C: Linea horizontal\n[INCORRECTA]', fontsize=7.5, color='#991b1b', fontweight='bold')
ins3.set_facecolor('#fff1f2'); ins3.grid(True, alpha=0.3)

ins4 = ax3.inset_axes([0.53, 0.04, 0.45, 0.44])
xD = np.linspace(0, 2, 100)
ins4.plot(xD, np.sin(3*xD)+2, color='#4ade80', lw=2)
ins4.set_title('D: Curva continua\n[INCORRECTA]', fontsize=7.5, color='#991b1b', fontweight='bold')
ins4.set_facecolor('#fff1f2'); ins4.grid(True, alpha=0.3)

plt.tight_layout()
plt.savefig(SAVE_PATH, dpi=150, bbox_inches='tight', facecolor='white')
print(f"Guardado en: {SAVE_PATH}")
plt.show()