class Hand {
  var cards: [Card]
  var handType = HandType.highCard

  init(cards: [Card]) {
    self.cards = cards
    self.handType = getHandType(cards: cards)
  }

  private func getHandType(cards: [Card]) -> HandType {
    for type in HandType.values.reversed() {
      if checkFor(type: type) { return type }
    }
    return HandType.highCard
  }

  private func checkFor(type: HandType) -> Bool {
    return HandType.conditions[type]!(self)
  }

  public func countDuplicatedRanks() -> [Int: Int] {
    var duplicatedRanks: [Int: Int] = [:]

    for compared in cards {
      duplicatedRanks[compared.rank.rawValue] = 0
      for comparedTo in cards {
        if comparedTo.rank.rawValue == compared.rank.rawValue {
          duplicatedRanks[compared.rank.rawValue]! += 1
        }
      }
    }

    return duplicatedRanks
  }
}