package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save() {
        Item item = new Item("itemA",100000,10);
        Item savedItem = itemRepository.save(item);
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        Item item1 = new Item("item1",100000,10);
        Item item2 = new Item("item2",200000,10);

        itemRepository.save(item1);
        itemRepository.save(item2);

        List<Item> result = itemRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1);
    }

    @Test
    void update() {
        Item item1 = new Item("item1",100000,10);
        Item savedItem = itemRepository.save(item1);
        Long itemId = savedItem.getId();

        Item updateParam = new Item("item2", 20000, 30);
        itemRepository.update(itemId,updateParam);

        Item findItem = itemRepository.findById(itemId);
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
    }

    @Test
    void clearStore() {
    }
}