package com.example.demo;

/**
 * 試合スケジュールに特化したデータ構造
 */
public record BaseballGame(
        String id,
        String date,      // 2026-05-02
        String startTime, // 14:00
        String awayTeam,
        String homeTeam,
        String venue,
        String status     // 試合前, 試合終了, 中止 など
) {}