package io.imrekaszab.algorithms.data.model.structure

class Tree {
    private var root: TreeNode? = null
    fun insert(value: Int) {
        if (root == null) {
            root = TreeNode(value)
        } else {
            root!!.insert(value)
        }
    }

    operator fun get(value: Int): TreeNode? {
        return if (root != null) {
            root!![value]
        } else null
    }

    fun delete(value: Int) {
        root = delete(root, value)
    }

    private fun delete(subtreeRoot: TreeNode?, value: Int): TreeNode? {
        if (subtreeRoot == null) {
            return subtreeRoot
        }
        if (value < subtreeRoot.data) {
            subtreeRoot.leftChild = delete(subtreeRoot.leftChild, value)
        } else if (value > subtreeRoot.data) {
            subtreeRoot.rightChild = delete(subtreeRoot.rightChild, value)
        } else {
            // Cases 1 and 2: node to delete has 0 or 1 child(ren)
            if (subtreeRoot.leftChild == null) {
                return subtreeRoot.rightChild
            } else if (subtreeRoot.rightChild == null) {
                return subtreeRoot.leftChild
            }

            // Case 3: node to delete has 2 children

            // Replace the value in the subtreeRoot node with the smallest value
            // from the right subtree
            subtreeRoot.data = subtreeRoot.rightChild.min()

            // Delete the node that has the smallest value in the right subtree
            subtreeRoot.rightChild = delete(subtreeRoot.rightChild, subtreeRoot.data)
        }
        return subtreeRoot
    }

    fun min(): Int {
        return if (root == null) {
            Int.MIN_VALUE
        } else {
            root!!.min()
        }
    }

    fun max(): Int {
        return if (root == null) {
            Int.MAX_VALUE
        } else {
            root!!.max()
        }
    }

    fun traverseInOrder() {
        if (root != null) {
            root!!.traverseInOrder()
        }
    }

    fun traversePreOrder() {
        if (root != null) {
            root!!.traversePreOrder()
        }
    }

    fun traversePostOrder() {
        if (root != null) {
            root!!.traversePostOrder()
        }
    }
}