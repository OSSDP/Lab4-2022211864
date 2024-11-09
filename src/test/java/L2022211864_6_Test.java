import org.example.Solution6;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class L2022211864_6_Test {

    private Solution6 solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution6();
    }

    /**
     * 测试用例设计的总体原则：
     * 1. 等价类划分：不同的用户收藏公司清单。
     * 2. 边界值分析：空列表、单元素列表、全包含列表等。
     * 3. 异常处理：非法输入（如 null）。
     */

    @Test
    public void testPeopleIndexes_Example1() {
        // 测试目的：检查正常情况下的输出
        // 用到的测试用例：多个用户的收藏公司清单
        List<List<String>> favoriteCompanies = List.of(
                List.of("leetcode", "google", "facebook"),
                List.of("google", "microsoft"),
                List.of("google", "facebook"),
                List.of("google"),
                List.of("amazon")
        );

        List<Integer> expected = Arrays.asList(0, 1, 4);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);

        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_Example2() {
        // 测试目的：检查部分用户收藏公司清单是其他用户的子集的情况
        // 用到的测试用例：部分用户的收藏公司清单是其他用户的子集
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("leetcode", "amazon"),
                Arrays.asList("facebook", "google")
        );

        List<Integer> expected = Arrays.asList(0, 1);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);

        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_Example3() {
        // 测试目的：检查所有用户的收藏公司清单都不是其他用户的子集的情况
        // 用到的测试用例：所有用户的收藏公司清单都是唯一的
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("leetcode"),
                Arrays.asList("google"),
                Arrays.asList("facebook"),
                Arrays.asList("amazon")
        );

        List<Integer> expected = Arrays.asList(0, 1, 2, 3);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);

        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_EmptyList() {
        // 测试目的：检查空列表的情况
        // 用到的测试用例：空的 favoriteCompanies 列表
        List<List<String>> favoriteCompanies = new ArrayList<>();

        List<Integer> expected = new ArrayList<>();
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);

        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_SingleUser() {
        // 测试目的：检查只有一个用户的情况
        // 用到的测试用例：只有一个用户的收藏公司清单
        List<List<String>> favoriteCompanies = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook")
        );

        List<Integer> expected = Arrays.asList(0);
        List<Integer> result = solution.peopleIndexes(favoriteCompanies);

        assertEquals(expected, result);
    }

    @Test
    public void testPeopleIndexes_NullInput() {
        // 测试目的：检查 null 输入的情况
        // 用到的测试用例：null 的 favoriteCompanies 列表
        List<List<String>> favoriteCompanies = null;

        assertThrows(NullPointerException.class, () -> {
            solution.peopleIndexes(favoriteCompanies);
        });
    }
}
