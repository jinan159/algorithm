package datastructure;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class HashTableTest {

    @Nested
    @DisplayName("size 메소드는")
    class SizeTest {

        @Test
        void 테이블이_빈_상태면_0을_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            int expected = 0;

            // when
            int size = hashTable.size();

            // then
            assertEquals(expected, size);
        }

        @Test
        void 테이블에_1개_넣으면_1을_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            hashTable.put("hello", "world");
            int expected = 1;

            // when
            int size = hashTable.size();

            // then
            assertEquals(expected, size);
        }

        @Test
        void 테이블에_2개_넣으면_2를_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            hashTable.put("hello", "world");
            hashTable.put("world", "hello");
            int expected = 2;

            // when
            int size = hashTable.size();

            // then
            assertEquals(expected, size);
        }

        @Test
        void 테이블에_1개_넣으고_1개를_빼면_0을_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            hashTable.put("hello", "world");
            hashTable.remove("hello");
            int expected = 0;

            // when
            int size = hashTable.size();

            // then
            assertEquals(expected, size);
        }

        @Test
        void 테이블에_1개_넣으고_1개를_수정하면_1을_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            hashTable.put("hello", "world");
            hashTable.put("hello", "world2");
            int expected = 1;

            // when
            int size = hashTable.size();

            // then
            assertEquals(expected, size);
        }

        @Test
        void 해시충돌이_일어나는_키가_2개라도_size_는_2가_반환된다() {
            // given
            HashTable<HashingByLengthKey, String> hashTable = new HashTable<>();
            hashTable.put(HashingByLengthKey.from("hello"), "hello hello");
            hashTable.put(HashingByLengthKey.from("world"), "world world");
            int expected = 2;

            // when
            int size = hashTable.size();

            // then
            assertEquals(expected, size);
        }
    }

    @Nested
    @DisplayName("isEmpty 메소드는")
    class IsEmptyTest {

        @Test
        void 테이블이_빈_상태면_true_를_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            boolean expected = true;

            // when
            boolean isEmpty = hashTable.isEmpty();

            // then
            assertEquals(expected, isEmpty);
        }

        @Test
        void 테이블에_1개_넣으면_false_를_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            hashTable.put("hello", "world");
            boolean expected = false;

            // when
            boolean isEmpty = hashTable.isEmpty();

            // then
            assertEquals(expected, isEmpty);
        }

        @Test
        void 테이블에_2개_넣으면_false_를_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            hashTable.put("hello", "world");
            hashTable.put("world", "hello");
            boolean expected = false;

            // when
            boolean isEmpty = hashTable.isEmpty();

            // then
            assertEquals(expected, isEmpty);
        }

        @Test
        void 테이블에_1개_넣으고_1개를_빼면_true_를_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            hashTable.put("hello", "world");
            hashTable.remove("hello");
            boolean expected = true;

            // when
            boolean isEmpty = hashTable.isEmpty();

            // then
            assertEquals(expected, isEmpty);
        }

        @Test
        void 테이블에_1개_넣으고_1개를_수정하면_false_를_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            hashTable.put("hello", "world");
            hashTable.put("hello", "world2");
            boolean expected = false;

            // when
            boolean isEmpty = hashTable.isEmpty();

            // then
            assertEquals(expected, isEmpty);
        }
    }

    @Nested
    class ContainsKeyTest {

        @Test
        void 테이블이_빈_상태면_false_를_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            String key = "key";
            boolean expected = false;

            // when
            boolean containsKey = hashTable.containsKey(key);

            // then
            assertEquals(expected, containsKey);
        }

        @Test
        void 테이블에_넣은_key_를_조회하면_true_를_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            String key = "hello";
            hashTable.put(key, "world");
            boolean expected = true;

            // when
            boolean containsKey = hashTable.containsKey(key);

            // then
            assertEquals(expected, containsKey);
        }

        @Test
        void 테이블에_넣지않은_key_를_조회하면_false_를_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            hashTable.put("hello", "world");
            String key = "key";
            boolean expected = false;

            // when
            boolean containsKey = hashTable.containsKey(key);

            // then
            assertEquals(expected, containsKey);
        }

        @Test
        void 해시충돌이_일어나는_키라도_조회하면_true_를_반환된다() {
            // given
            HashTable<HashingByLengthKey, String> hashTable = new HashTable<>();
            HashingByLengthKey key1 = HashingByLengthKey.from("hello");
            HashingByLengthKey key2 = HashingByLengthKey.from("world");
            hashTable.put(key1, "hello hello");
            hashTable.put(key2, "world world");
            boolean expected = true;

            // when
            boolean containsKey1 = hashTable.containsKey(key1);
            boolean containsKey2 = hashTable.containsKey(key1);

            // then
            assertAll(
                () -> assertEquals(expected, containsKey1),
                () -> assertEquals(expected, containsKey2)
            );
        }
    }

    @Nested
    class GetTest {

        @Test
        void 테이블이_빈_상태면_null_을_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            boolean expected = true;

            // when
            boolean isEmpty = hashTable.isEmpty();

            // then
            assertEquals(expected, isEmpty);
        }

        @Test
        void 테이블에_있는_항목이면_값을_반환한다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            String key = "hello";
            String expectedValue = "world";
            hashTable.put(key, expectedValue);

            // when
            String returnedValue = hashTable.get(key);

            // then
            assertEquals(expectedValue, returnedValue);
        }
    }

    @Nested
    class PutTest {

        @Test
        void 테이블에_넣으면_정상적으로_저장된다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            String key = "hello";
            String expectedValue = "world";

            // when
            hashTable.put(key, expectedValue);

            // then
            String savedValue = hashTable.get(key);
            assertEquals(expectedValue, savedValue);
        }

        @Test
        void 테이블에_기존_키에_다른값을_넣으면_수정된다() {
            // given
            HashTable<String, String> hashTable = new HashTable<>();
            String key = "hello";
            hashTable.put(key, "world"); // first put

            String expectedValue = "world_월드";

            // when
            hashTable.put(key, expectedValue); // second put

            // then
            String savedValue = hashTable.get(key);
            assertEquals(expectedValue, savedValue);
        }

        @Test
        void 해시충돌이_일어나는_키라도_정상적으로_저장된다() {
            // given
            HashTable<HashingByLengthKey, String> hashTable = new HashTable<>();
            HashingByLengthKey key1 = HashingByLengthKey.from("hello");
            HashingByLengthKey key2 = HashingByLengthKey.from("world");
            String expectedValue1 = "hello hello";
            String expectedValue2 = "world world";

            // when
            hashTable.put(key1, expectedValue1);
            hashTable.put(key2, expectedValue2);

            // then
            String savedValue1 = hashTable.get(key1);
            String savedValue2 = hashTable.get(key2);
            assertAll(
                () -> assertEquals(expectedValue1, savedValue1),
                () -> assertEquals(expectedValue2, savedValue2)
            );
        }

        @Test
        void 해시충돌이_일어나는_키라도_정상적으로_수정된다() {
            // given
            HashTable<HashingByLengthKey, String> hashTable = new HashTable<>();
            HashingByLengthKey key1 = HashingByLengthKey.from("hello");
            HashingByLengthKey key2 = HashingByLengthKey.from("world");
            String expectedValue1 = "hello hello world";
            String expectedValue2 = "world world hello";

            // firstPut
            hashTable.put(key1, "hello");
            hashTable.put(key2, "world");

            // when
            hashTable.put(key1, expectedValue1);
            hashTable.put(key2, expectedValue2);

            // then
            String updatedValue1 = hashTable.get(key1);
            String updatedValue2 = hashTable.get(key2);
            assertAll(
                () -> assertEquals(expectedValue1, updatedValue1),
                () -> assertEquals(expectedValue2, updatedValue2)
            );
        }
    }

    private static class HashingByLengthKey {
        private String value;

        public static HashingByLengthKey from(String keyValue) {
            HashingByLengthKey key = new HashingByLengthKey();
            key.value = keyValue;
            return key;
        }

        @Override
        public int hashCode() {
            return value.length();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (!(obj instanceof HashingByLengthKey)) return false;

            HashingByLengthKey objKey = (HashingByLengthKey) obj;
            return objKey.hashCode() == hashCode();
        }
    }
}