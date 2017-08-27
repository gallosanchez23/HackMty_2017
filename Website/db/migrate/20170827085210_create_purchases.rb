class CreatePurchases < ActiveRecord::Migration[5.1]
  def change
    create_table :purchases do |t|
    	t.datetime 	 :date, null: false
    	t.integer		 :total_cost
    	t.references :store, index: true, foreign_key: true
    	t.references :user,	 index: true, foreign_key: true

      t.timestamps
    end
  end
end
