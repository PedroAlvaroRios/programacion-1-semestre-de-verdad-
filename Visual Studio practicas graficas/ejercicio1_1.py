import numpy as np
import matplotlib.pyplot as plt
import matplotlib.patches as mpatches
import os
import tempfile

# Función que simula la latencia L(t)
# Continua en t=5, valor = 20 ms en ambos lados
def L(t):
    return 20 + 2 * np.sin(t - 5) * np.exp(-0.5 * (t - 5)**2)

t = np.linspace(0, 10, 500)
y = L(t)

fig, axes = plt.subplots(1, 2, figsize=(13, 5))
fig.suptitle('Ejercicio 1 — Continuidad en t = 5\nLatencia promedio de red L(t)', 
             fontsize=13, fontweight='bold', color='#1e3a5f')

# ── Gráfica izquierda: función continua (caso correcto) ──
ax1 = axes[0]
ax1.plot(t, y, color='#0ea5e9', linewidth=2.5, label='L(t) — Latencia')
ax1.axvline(x=5, color='#f59e0b', linestyle='--', linewidth=1.5, label='t = 5')
ax1.axhline(y=20, color='#4ade80', linestyle=':', linewidth=1.5, label='L = 20 ms')

# Límite izquierdo
ax1.annotate('', xy=(5, 20), xytext=(3.5, 20),
             arrowprops=dict(arrowstyle='->', color='#a78bfa', lw=2))
ax1.text(2.8, 20.5, 'lím L(t) = 20\nt→5⁻', fontsize=9, color='#a78bfa', ha='center')

# Límite derecho
ax1.annotate('', xy=(5, 20), xytext=(6.5, 20),
             arrowprops=dict(arrowstyle='->', color='#f87171', lw=2))
ax1.text(7.2, 20.5, 'lím L(t) = 20\nt→5⁺', fontsize=9, color='#f87171', ha='center')

# Punto en t=5
ax1.plot(5, 20, 'o', color='#4ade80', markersize=10, zorder=5, label='L(5) = 20 ms')

ax1.set_xlabel('Tiempo t (segundos)', fontsize=11)
ax1.set_ylabel('Latencia L(t) (ms)', fontsize=11)
ax1.set_title('[OK] Función CONTINUA en t = 5\n(Respuesta correcta: opción B)', 
              fontsize=10, color='#166534', fontweight='bold')
ax1.legend(fontsize=9)
ax1.grid(True, alpha=0.3)
ax1.set_facecolor('#f8fafc')
ax1.set_ylim(14, 26)

# Caja con conclusión
ax1.text(0.5, 0.08, 
         'lím L(t) = lím L(t) = L(5) = 20  →  CONTINUA',
         transform=ax1.transAxes, fontsize=8.5, ha='center',
         bbox=dict(boxstyle='round', facecolor='#dcfce7', edgecolor='#4ade80', alpha=0.9))

# ── Gráfica derecha: comparación con una función discontinua ──
ax2 = axes[1]

# Función con discontinuidad de salto para comparar
t1 = np.linspace(0, 4.99, 200)
t2 = np.linspace(5.01, 10, 200)
y1 = 15 + 0.5 * t1
y2 = 22 + 0.3 * (t2 - 5)

ax2.plot(t1, y1, color='#f87171', linewidth=2.5, label='Caso discontinuo (referencia)')
ax2.plot(t2, y2, color='#f87171', linewidth=2.5)
ax2.plot(t, y, color='#0ea5e9', linewidth=2.5, linestyle='--', alpha=0.6, label='L(t) continua')

# Círculo vacío (límite izquierdo)
ax2.plot(5, y1[-1], 'o', color='#f87171', markersize=9, markerfacecolor='white', 
         markeredgewidth=2, zorder=5)
# Círculo relleno (límite derecho distinto)
ax2.plot(5, y2[0], 'o', color='#f87171', markersize=9, zorder=5)
# Punto real de la función continua
ax2.plot(5, 20, 'o', color='#0ea5e9', markersize=10, zorder=6, label='L(5)=20 (continua)')

ax2.axvline(x=5, color='#f59e0b', linestyle='--', linewidth=1.5)
ax2.set_xlabel('Tiempo t (segundos)', fontsize=11)
ax2.set_ylabel('Latencia L(t) (ms)', fontsize=11)
ax2.set_title('Comparación: Continua vs Discontinua\n(para entender la diferencia)', 
              fontsize=10, color='#1e3a5f', fontweight='bold')
ax2.legend(fontsize=9)
ax2.grid(True, alpha=0.3)
ax2.set_facecolor('#f8fafc')

ax2.text(0.5, 0.08,
         '[X] Salto: límites laterales distintos\n[OK] Continua: límites iguales y = f(5)',
         transform=ax2.transAxes, fontsize=8.5, ha='center',
         bbox=dict(boxstyle='round', facecolor='#fef3c7', edgecolor='#f59e0b', alpha=0.9))

plt.tight_layout()
out_path = os.path.join(tempfile.gettempdir(), 'ejercicio1.png')
plt.savefig(out_path, dpi=150, bbox_inches='tight', facecolor='white')
print('Saved plot to:', out_path)