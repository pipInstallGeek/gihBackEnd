import numpy as np
import sys

def predict_revision_time(x, A, B, q):
    alpha = np.zeros(3)
    for i in range(3):
        alpha[i] = (A[i] - x) / B[i]
    
    P = np.array([[alpha[0], (1 - alpha[0]) * q, 0],
                  [1 - alpha[1], alpha[1], 0],
                  [1 - alpha[2], 0.0, alpha[2]]])
    
    def m(i, j):
        m_i_j = (P[i][i] + P[i][j] - (P[i][i] * P[j][j]) + (P[i][j] * P[j][i])) / (
                    1 - P[i][i] - P[j][j] + (P[i][i] * P[j][j]) - (P[i][j] * P[j][i]))
        return m_i_j

    return f"Le vehicule prendra {int(m(0, 2))} semaines pour passer a une revision courte duree, et {int(m(0, 1))} semaines pour passer a une revision longue duree"

x = float(sys.argv[1])
A = list(map(float, sys.argv[2].split()))
B = list(map(float, sys.argv[3].split()))
q = float(sys.argv[4])

result = predict_revision_time(x, A, B, q)
print(result)
