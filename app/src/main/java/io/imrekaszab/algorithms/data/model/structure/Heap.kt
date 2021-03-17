package io.imrekaszab.algorithms.data.model.structure

class Heap(capacity: Int) {
    private val heap: IntArray = IntArray(capacity)
    private var size = 0

    fun insert(value: Int) {
        if (isFull) {
            throw IndexOutOfBoundsException("Heap is full")
        }
        heap[size] = value
        fixHeapAbove(size)
        size++
    }

    fun peek(): Int {
        if (isEmpty) {
            throw IndexOutOfBoundsException("Heap is empty")
        }
        return heap[0]
    }

    fun delete(index: Int): Int {
        if (isEmpty) {
            throw IndexOutOfBoundsException("Heap is empty")
        }
        val parent = getParent(index)
        val deletedValue = heap[index]
        heap[index] = heap[size - 1]
        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1)
        } else {
            fixHeapAbove(index)
        }
        size--
        return deletedValue
    }

    fun sort() {
        val lastHeapIndex = size - 1
        for (i in 0 until lastHeapIndex) {
            val tmp = heap[0]
            heap[0] = heap[lastHeapIndex - i]
            heap[lastHeapIndex - i] = tmp
            fixHeapBelow(0, lastHeapIndex - i - 1)
        }
    }

    private fun fixHeapAbove(currentIndex: Int) {
        var index = currentIndex
        val newValue = heap[index]
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)]
            index = getParent(index)
        }
        heap[index] = newValue
    }

    private fun fixHeapBelow(currentIndex: Int, lastHeapIndex: Int) {
        var index = currentIndex
        var childToSwap: Int
        while (index <= lastHeapIndex) {
            val leftChild = getChild(index, true)
            val rightChild = getChild(index, false)
            if (leftChild <= lastHeapIndex) {
                childToSwap = if (rightChild > lastHeapIndex) {
                    leftChild
                } else {
                    if (heap[leftChild] > heap[rightChild]) leftChild else rightChild
                }
                if (heap[index] < heap[childToSwap]) {
                    val tmp = heap[index]
                    heap[index] = heap[childToSwap]
                    heap[childToSwap] = tmp
                } else {
                    break
                }
                index = childToSwap
            } else {
                break
            }
        }
    }

    fun printHeap() {
        for (i in 0 until size) {
            print(heap[i])
            print(", ")
        }
        println()
    }

    private val isFull: Boolean
        get() = size == heap.size

    private fun getParent(index: Int): Int {
        return (index - 1) / 2
    }

    private val isEmpty: Boolean
        get() = size == 0

    private fun getChild(index: Int, left: Boolean): Int {
        return 2 * index + if (left) 1 else 2
    }

}