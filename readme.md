# bipartite

Bipartite matching algorithms.

## gale-shapely

The typical Gale-Shapely algorithm.

> Given a bipartite graph and a preference list for each node, return a list of bipartite pairs such that all nodes are matched.

Constraints:

- The bipartite graph has an equal number of nodes.
- Each preference list is complete, that is, contains a full list of nodes in the other graph.

e.g.

```
Vorschlagen Mann 0 und Frau 0
Die Frau 0 ist frei.
Verlobung ist [[0, 0]]
Vorschlag fertig. Vorschlag ist {0=[0]}
[[0, 0]]
Vorschlagen Mann 1 und Frau 0
Die Frau 0 ist nicht frei.
Der Mann, mit ihm sie in einem Paar schon steht ist 0
Der Mann 1 steht höher. Tauschen.
Verlobung ist [[1, 0]]
Vorschlag fertig. Vorschlag ist {0=[0], 1=[0]}
[[1, 0]]
Vorschlagen Mann 0 und Frau 2
Die Frau 2 ist frei.
Verlobung ist [[1, 0], [0, 2]]
Vorschlag fertig. Vorschlag ist {0=[0, 2], 1=[0]}
[[1, 0], [0, 2]]
Vorschlagen Mann 2 und Frau 2
Die Frau 2 ist nicht frei.
Der Mann, mit ihm sie in einem Paar schon steht ist 0
Der Mann 2 steht höher. Tauschen.
Verlobung ist [[1, 0], [2, 2]]
Vorschlag fertig. Vorschlag ist {0=[0, 2], 1=[0], 2=[2]}
[[1, 0], [2, 2]]
Vorschlagen Mann 0 und Frau 1
Die Frau 1 ist frei.
Verlobung ist [[1, 0], [2, 2], [0, 1]]
Vorschlag fertig. Vorschlag ist {0=[0, 1, 2], 1=[0], 2=[2]}
[[1, 0], [2, 2], [0, 1]]
```
