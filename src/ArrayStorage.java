/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;
    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
            size = 0;
        }

    }

    void save(Resume r) {
        storage[size ] = r;
        size = size++;
    }

    Resume get(String uuid) {
        int n = 0;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                n = i;
            }
        }
        return storage[n];
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                System.arraycopy(storage, i + 1, storage, i, storage.length - i);
            }
        }
        size --;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return System.arraycopy(storage, 0, new Resume[], 0, size);
    }

    int size() {
        return size;
    }
}

