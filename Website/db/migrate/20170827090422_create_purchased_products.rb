class CreatePurchasedProducts < ActiveRecord::Migration[5.1]
  def change
    create_table :purchased_products do |t|
    	t.references :purchase, index: true, foreign_key: true
    	t.references :product, index: true, foreign_key: true
    	t.integer		 :quantity, null: false, default: 1

      t.timestamps
    end
  end
end
