# java-treemodel-dfs
Java implementation for a LinkedTree and SequentialTree that is extendable and provides a DFS algorithm.

The abstract `Tree` model in this project is implemented using
* a `LinkedTree` implementation and
* a `SequentialTree` implementation.
The model abstracts from the underlying implementation by providing the same methods for the two different classes.

Both implementations can be extended by using another class as nodes. A sample implementation can be found in the project's tests where the `MockLinkedTree` extends the `LinkedTree`.

All tree implementations can be traversed using a DFS (depth-first-search) algorithm. You can provide any action to the DFS that should be executed during the traversal. A sample implementation can be again found in the project's tests where the `MockLinkedTreeMeasurer` uses the DFS to count all nodes in the tree.

# Copyright and license
The code and its documentation contained in this GitHub repository are licensed under [GNU General Public License v3.0](LICENSE).