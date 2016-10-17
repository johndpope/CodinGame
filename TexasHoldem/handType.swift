enum HandType: Int {
  case highCard, pair, twoPair, threeOfaKind, straight
  case flush, fullHouse, fourOfaKind, straightFlush

  static let values = [highCard, pair, twoPair, threeOfaKind, straight,
                      flush, fullHouse, fourOfaKind, straightFlush]

  static let conditions: [HandType: (Hand) -> Bool] = [
    // Check for high card (always true)
    highCard: { (hand: Hand) -> Bool in return true },
    // Check for pair (true if two duplicates of the same rank)
    pair: { (hand: Hand) -> Bool in
      for (rank, duplicated) in hand.countDuplicatedRanks() {
        if duplicated == 2 { return true }
      }
      return false
    },
  ]
}