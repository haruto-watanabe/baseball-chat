package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GameController {

    // 本来はDBやAPIから取得しますが、今回はサンプルデータを保持
    private final List<BaseballGame> mockGames = List.of(
            new BaseballGame("g1", "2026-05-02", "14:00", "中日", "横浜DeNA", "バンテリンドーム", "LIVE"),
            new BaseballGame("g2", "2026-05-02", "18:00", "巨人", "広島", "東京ドーム", "18:00開始"),
            new BaseballGame("g3", "2026-05-03", "13:30", "ヤクルト", "阪神", "神宮", "13:30開始")
    );

    @GetMapping("/api/games")
    public List<BaseballGame> getGamesByDate(@RequestParam String date) {
        // 指定された日付の試合だけをフィルタリングして返す
        return mockGames.stream()
                .filter(game -> game.date().equals(date))
                .collect(Collectors.toList());
    }
}