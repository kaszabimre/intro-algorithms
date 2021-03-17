package io.imrekaszab.algorithms.data.model.structure

class TreeNode(var data: Int) {
    var leftChild: TreeNode? = null
    var rightChild: TreeNode? = null
    fun insert(value: Int) {
        if (value == data) {
            return
        }
        if (value < data) {
            if (leftChild == null) {
                leftChild = TreeNode(value)
            } else {
                leftChild!!.insert(value)
            }
        } else {
            if (rightChild == null) {
                rightChild = TreeNode(value)
            } else {
                rightChild!!.insert(value)
            }
        }
    }

    operator fun get(value: Int): TreeNode? {
        if (value == data) {
            return this
        }
        if (value < data) {
            if (leftChild != null) {
                return leftChild!![value]
            }
        } else {
            if (rightChild != null) {
                return rightChild!![value]
            }
        }
        return null
    }

    fun min(): Int {
        return if (leftChild == null) {
            data
        } else {
            leftChild!!.min()
        }
    }

    fun max(): Int {
        return if (rightChild == null) {
            data
        } else {
            rightChild!!.max()
        }
    }

    fun traverseInOrder() {
        if (leftChild != null) {
            leftChild!!.traverseInOrder()
        }
        print("$data, ")
        if (rightChild != null) {
            rightChild!!.traverseInOrder()
        }
    }

    fun traversePreOrder() {
        print("$data, ")
        if (leftChild != null) {
            leftChild!!.traversePreOrder()
        }
        if (rightChild != null) {
            rightChild!!.traversePreOrder()
        }
    }

    fun traversePostOrder() {
        if (leftChild != null) {
            leftChild!!.traversePostOrder()
        }
        if (rightChild != null) {
            rightChild!!.traversePostOrder()
        }
        print("$data, ")
    }

    override fun toString(): String {
        return "Data = $data"
    }
}