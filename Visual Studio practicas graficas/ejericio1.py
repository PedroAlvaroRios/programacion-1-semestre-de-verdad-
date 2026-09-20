import numpy as np
import matplotlib.pyplot as plt

# Función por partes
def f(x):
    if x < 2:
        return x + 1          # cuando x→2⁻, f→3
    elif x > 2:
        return 5              # constante 5 → límite derecho = 5
    else:
        return 10             # valor en x=2, no afecta los límites

x_vals = np.linspace(0, 4, 500)
y_vals = [f(x) for x in x_vals]

plt.figure(figsize=(7, 5))
plt.plot(x_vals, y_vals, 'b-', linewidth=2, label=r'$f(x)$')
# Punto en x=2
plt.plot(2, 10, 'ro', markersize=10, label='f(2)=10 (valor funcional)')
# Límites laterales
plt.plot(2, 3, 'go', markersize=8, fillstyle='none', label='Límite izquierdo = 3')
plt.plot(2, 5, 'mo', markersize=8, fillstyle='none', label='Límite derecho = 5')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.title('Los límites laterales (3 y 5) no dependen de f(2)=10')
plt.legend()
plt.grid(True)
plt.show()