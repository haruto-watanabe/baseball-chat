package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://haruto-watanabe.github.io")
public class GameController {

    private final GameService gameService;

    // コンストラクタ注入（推奨される設計です）
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * 日付を指定して試合リストを取得するAPI
     * 例: /api/games?date=2026-05-02
     */
    @GetMapping("/api/games")
    public List<BaseballGame> getGamesByDate(@RequestParam String date) {
        // 実際の処理は Service クラスに任せる
        return gameService.getGamesByDate(date);
    }
}