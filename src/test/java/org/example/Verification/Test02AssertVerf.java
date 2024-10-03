package org.example.Verification;

import org.testng.annotations.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


public class Test02AssertVerf {


    @Test
    public void test_verify_assertJ()
    {
        String name= "Pramod";

        assertThat(name).isEqualTo("Pramod").isNotEmpty().isNotNull();

        List<String> names = Arrays.asList("John", "Kunal", "Hero");
        assertThat(names).hasSize(3).isNotNull();

        LocalDate date =LocalDate.now();
        System.out.println(date);

        assertThat(date)
                .isAfterOrEqualTo(LocalDate.of(2021, 1, 1))
                .isBeforeOrEqualTo(LocalDate.of(2024, 12, 31))
                .isBetween(
                        LocalDate.of(2023, 1, 1),
                        LocalDate.of(2024, 12, 31)
                );

        File file = new File("D:/APIEco mm/TestData.json");
        assertThat(file).exists().isFile().canRead();

        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Jane", 30);

        assertThat(ages).hasSize(2).containsEntry("John",25).doesNotContainValue(40);


    }

}
